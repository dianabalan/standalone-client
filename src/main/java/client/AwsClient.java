package client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;

public class AwsClient {

  public static void main(final String[] args) throws IOException {
    // Setup credentials
    final BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAIR473EADM7MJTUXQ", "mGrJF6oumnfJxGGYpDtTCh8mXHqj1XZF1DFtEg3K");

    final AWSLambdaClient client = new AWSLambdaClient(new StaticCredentialsProvider(awsCreds));
    client.withRegion(Regions.US_EAST_1);
    final String content = new String(Files.readAllBytes(Paths.get("src/main/resources/s3event.json")));

    // Create an InvokeRequest
    final InvokeRequest request = new InvokeRequest().withFunctionName("resize-function").withPayload(content);

    try {
      // Execute the InvokeRequest
      final InvokeResult result = client.invoke(request);

      // We should validate the response
      System.out.println("Status Code: " + result.getStatusCode());

      // Get the response as JSON
      final String json = new String(result.getPayload().array(), "UTF-8");

      // Show the response; we could use a library like Jackson to convert this to an object
      System.out.println(json);
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

}
