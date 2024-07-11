package com.danunaik.trytestapplication.navigation

import android.app.Activity
import com.danunaik.common_utils.Activities
import com.danunaik.common_utils.Navigator
import com.danunaik.news_presentation.GoToNewsActivity
import com.danunaik.search_presentation.SearchActivity


class DefaultNavigator: Navigator.Provider {
    override fun getActivities(activities: Activities): Navigator {
        return when(activities){
            Activities.NewsActivity->{
                GoToNewsActivity
            }
            Activities.SearchActivity->{
                SearchActivity.GoToSearchActivity
            }
        }
    }


}
