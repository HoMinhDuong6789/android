package retrofit;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Minh on 2/24/2020.
 *
 * dung de gui nhung yeu cau len cho server, vd nhung phuong thuc GET, PUT, POST, DELETE
 */
public interface DataClient {

    @Multipart
    @POST("upload.php")
    Call<String> uploadPhoto(@Part MultipartBody.Part photo);


}
