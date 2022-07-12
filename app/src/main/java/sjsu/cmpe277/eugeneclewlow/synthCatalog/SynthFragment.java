package sjsu.cmpe277.eugeneclewlow.synthCatalog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.UUID;

public class SynthFragment extends Fragment {
    private Synth mSynth;

    private TextView mTitle;
    private TextView mDesc;
    private ImageView mImage;
    private static final String ARG_SYNTH_ID = "synth_id";

    public static SynthFragment newInstance(UUID synthId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_SYNTH_ID, synthId);

        SynthFragment fragment = new SynthFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID synthId = (UUID) getArguments().getSerializable(ARG_SYNTH_ID);
        mSynth = SynthLab.get(getActivity()).getSynth(synthId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_synth, container, false);

        mTitle = (TextView) v.findViewById(R.id.synth_title_label);
        mTitle.setText(mSynth.getTitleResId());

        mDesc = (TextView) v.findViewById(R.id.synth_desc_label);
        mDesc.setText(mSynth.getDescResId());

        mImage = (ImageView) v.findViewById(R.id.synth_image_label);
        mImage.setImageResource(mSynth.getImageResId());

        return v;
    }
}
