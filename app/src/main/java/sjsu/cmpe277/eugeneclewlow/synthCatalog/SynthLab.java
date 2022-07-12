package sjsu.cmpe277.eugeneclewlow.synthCatalog;

import android.content.Context;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SynthLab {
    private static SynthLab sSynthLab;
    private List<Synth> mSynths = Arrays.asList(
            new Synth(
                    R.string.synth_title_behrpolyd,
                    R.string.synth_desc_behrpolyd,
                    R.drawable.behrpolyd),
            new Synth(R.string.synth_title_grandmother,
                    R.string.synth_desc_grandmother,
                    R.drawable.grandmother),
            new Synth(R.string.synth_title_ju06a,
                    R.string.synth_desc_ju06a,
                    R.drawable.ju06a),
            new Synth(R.string.synth_title_minimoog,
                    R.string.synth_desc_minimoog,
                    R.drawable.minimoog),
            new Synth(R.string.synth_title_system8,
                    R.string.synth_desc_system8,
                    R.drawable.system8)
    );

    public static SynthLab get(Context context) {
        if (sSynthLab == null) {
            sSynthLab = new SynthLab(context);
        }
        return sSynthLab;
    }

    private SynthLab(Context context) {
    }

    public List<Synth> getSynths() {
        return mSynths;
    }

    public Synth getSynth(UUID id) {
        for (Synth synth : mSynths) {
            if (synth.getId().equals(id)) {
                return synth;
            }
        }

        return null;
    }

}
