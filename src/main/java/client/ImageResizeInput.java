package client;

public class ImageResizeInput {

  private String bucketName;
  private String imageName;

  public String getBucketName() {
    return bucketName;
  }
  public String getImageName() {
    return imageName;
  }
  public void setBucketName(final String bucketName) {
    this.bucketName = bucketName;
  }
  public void setImageName(final String imageName) {
    this.imageName = imageName;
  }

}
