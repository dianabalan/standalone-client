package client;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

public interface ImageResizeService {

  @LambdaFunction(functionName = "resize-function")
  String resizeImage(ImageResizeInput input);
}
