package sjsu.cmpe277.eugeneclewlow.synthCatalog;

import androidx.fragment.app.Fragment;

public class SynthListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new SynthListFragment();
    }
}