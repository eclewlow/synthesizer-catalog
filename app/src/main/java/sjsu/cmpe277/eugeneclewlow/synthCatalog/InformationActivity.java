package sjsu.cmpe277.eugeneclewlow.synthCatalog;

import androidx.fragment.app.Fragment;

public class InformationActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new InformationFragment();
    }
}
