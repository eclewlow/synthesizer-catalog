package sjsu.cmpe277.eugeneclewlow.synthCatalog;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class SynthActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {

        UUID synthId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_SYNTH_ID);
        return SynthFragment.newInstance(synthId);

    }

    private static final String EXTRA_SYNTH_ID =
            "sjsu.cmpe277.eugeneclewlow.synthCatalog";

    public static Intent newIntent(Context packageContext, UUID synthId) {
        Intent intent = new Intent(packageContext, SynthActivity.class);
        intent.putExtra(EXTRA_SYNTH_ID, synthId);
        return intent;
    }

}