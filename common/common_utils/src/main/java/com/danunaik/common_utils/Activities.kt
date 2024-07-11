package com.danunaik.common_utils

 sealed class Activities {
     data object NewsActivity: Activities()
     data object  SearchActivity:Activities()
}