package presenter;

import data.FitAddObject;
import data.FitElement;

import java.util.List;

/**
 * Created by once2go on 19/01/17.
 */
public interface Agent {

    List<FitElement> parseContainer(String url);

    FitAddObject parseTargetPage(FitElement element);
}
