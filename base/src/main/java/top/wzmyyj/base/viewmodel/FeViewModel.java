package top.wzmyyj.base.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.DefaultLifecycleObserver;

/**
 * Created on 2019/09/29.
 *
 * @author feling
 * @version 1.0
 * @since 1.0
 */
public class FeViewModel extends AndroidViewModel implements DefaultLifecycleObserver {

    public FeViewModel(@NonNull Application application) {
        super(application);
    }
}
