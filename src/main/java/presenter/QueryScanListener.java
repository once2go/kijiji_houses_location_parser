package presenter;

import data.FitElement;

import java.util.List;

/**
 * Created by once2go on 20/01/17.
 */
public interface QueryScanListener {
    void onParseFinished(List<FitElement> result);
}
