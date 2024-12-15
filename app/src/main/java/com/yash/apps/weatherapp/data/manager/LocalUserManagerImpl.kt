package com.yash.apps.weatherapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.yash.apps.weatherapp.domain.manager.LocalUserManager
import com.yash.apps.weatherapp.util.Constants.LOCATION_PREFERENCES
import com.yash.apps.weatherapp.util.Constants.SAVED_LOCATION
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager {
    override suspend fun saveLocation(location: String) {
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.SAVED_LOCATION_KEY] = location
        }
    }

    override fun readSavedLocation(): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.SAVED_LOCATION_KEY]
        }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = LOCATION_PREFERENCES
)

private object PreferencesKeys {
    val SAVED_LOCATION_KEY = stringPreferencesKey(SAVED_LOCATION)
}