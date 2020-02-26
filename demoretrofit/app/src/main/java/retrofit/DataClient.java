package retrofit;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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

    @FormUrlEncoded
    @POST("insert.php")
    Call<String> InsertData(@Field("taikhoan") String taikhoan
                            ,@Field("matkhau") String matkhau
                            ,@Field("hinhanh") String hinhanh);


    @FormUrlEncoded
    @POST("login.php")
    Call<List<SinhVien>> logindata(@Field("taikhoan") String taikhoan
            , @Field("matkhau") String matkhau);
}
