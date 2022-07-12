package sjsu.cmpe277.eugeneclewlow.synthCatalog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SynthListFragment extends Fragment {
    private RecyclerView mSynthRecyclerView;
    private SynthAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_synth_list, container, false);

        mSynthRecyclerView = (RecyclerView) view
                .findViewById(R.id.synth_recycler_view);
        mSynthRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        SynthLab synthLab = SynthLab.get(getActivity());
        List<Synth> synths = synthLab.getSynths();

        if (mAdapter == null) {
            mAdapter = new SynthAdapter(synths);
            mSynthRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }

        mSynthRecyclerView.setAdapter(mAdapter);
    }

    private class SynthAdapter extends RecyclerView.Adapter<SynthHolder> {

        private List<Synth> mSynths;

        public SynthAdapter(List<Synth> synths) {
            mSynths = synths;
        }

        @NonNull
        @Override
        public SynthHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new SynthHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SynthHolder holder, int position) {
            Synth synth = mSynths.get(position);
            holder.bind(synth);
        }

        @Override
        public int getItemCount() {
            return mSynths.size();
        }

    }


    private class SynthHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Synth mSynth;
        private TextView mTitleTextView;
        private ImageView mImageView;


        public SynthHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_synth, parent, false));
            mTitleTextView = (TextView) itemView.findViewById(R.id.synth_title);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(this);

        }

        public void bind(Synth synth) {
            mSynth = synth;
            mTitleTextView.setText(mSynth.getTitleResId());
            mImageView.setImageResource(mSynth.getImageResId());
        }

        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            builder.setMessage(R.string.dialog_text);
            builder.setPositiveButton("KNOW MORE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = SynthActivity.newIntent(getActivity(), mSynth.getId());
            startActivity(intent);
                }
            });
            builder.setNegativeButton("CANCEL", null);
            builder.show();
        }
    }
}
