package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;

import org.json.JSONException;
import org.json.JSONObject;

class PathKeyframe extends Keyframe<PointF> {

  private Path path;


  PathKeyframe(JSONObject json, LottieComposition composition,
      PathValueDeserializer valueDeserializer) throws JSONException {
    super(json, composition, composition.getScale(), valueDeserializer);
    PointF cp1 = null;
    PointF cp2 = null;
    if (json.has("to") && json.has("ti")) {
      cp1 =
          JsonUtils.pointFromJsonArray(json.getJSONArray("to"), composition.getScale());
      cp2 =
          JsonUtils.pointFromJsonArray(json.getJSONArray("ti"), composition.getScale());
    }

    if (endValue != null) {
      path = valueDeserializer.createPath(startValue, endValue, cp1, cp2);
    }
  }

  Path getPath() {
    return path;
  }
}
