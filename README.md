# books_mobile_parcial2
- Para el consumo de https://jsonplaceholder.typicode.com/posts, e implementación del Recycler View ejecutar actividad MainActivity:
```kotlin
Manifest.xml:
<activity
            android:name=".PostViewActivity"
            android:exported="false" />
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

- Para agregar Libro a la bd ejecutar actividad PostViewActivity:
```kotlin
Manifest.xml:
<activity
            android:name=".MainActivity"
            android:exported="false" />
        <activity
            android:name=".PostViewActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
</activity>
```

- Para verificar que se agrega a la bd, se muestran los registros de la bd en consola
    
