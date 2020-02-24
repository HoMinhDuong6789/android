package retrofit;

/**
 * Created by Minh on 2/24/2020.
 * dung de cung cap duogn dan
 */
public class APIUtils {
    public static final String Base_url = "http://192.168.31.26/quanlysinhvien/";
    public  static DataClient getDataClient(){
        // dung de nhan va gui du lieu ve, chwas du lieu tra ve trong thang Interface DataClient
        return RetrofitClient.getClient(Base_url).create(DataClient.class);
    }

}
