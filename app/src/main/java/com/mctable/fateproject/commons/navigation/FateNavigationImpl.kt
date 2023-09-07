import android.content.Context
import android.content.Intent
import com.mctable.commons.ds.navigation.AppConstants
import com.mctable.commons.ds.navigation.FateNavigation
import com.mctable.commons.ds.navigation.FeatureModuleRef
import com.mctable.namodule.NaMainActivity

class FateNavigationImpl(private val context: Context) : FateNavigation {
    override fun navigate(featureModuleRef: FeatureModuleRef, route: String?) {
        val intent = Intent()
        when (featureModuleRef) {
            FeatureModuleRef.NA -> {
                intent.setClass(context, NaMainActivity::class.java)
                intent.action = NaMainActivity::class.java.name
                intent.putExtra(AppConstants.Keys.ROUTE_KEY, route)
            }
        }
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }
}