package com.danunaik.trytestapplication

import com.danunaik.common_utils.Navigator
import com.danunaik.trytestapplication.navigation.DefaultNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MainModule {

    @Provides
    @Singleton
    fun provideProvider():Navigator.Provider{
        return DefaultNavigator()
    }
}