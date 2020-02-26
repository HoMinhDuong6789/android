package retrofit;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SinhVien  implements Parcelable {
/*
ho tro do du lieu kieu mang doi tuong, giup gui nhanh hon
 */
@SerializedName("id")
@Expose
private String id;
@SerializedName("taikhoan")
@Expose
private String taikhoan;
@SerializedName("matkhau")
@Expose
private String matkhau;
@SerializedName("hinhanh")
@Expose
private String hinhanh;

    protected SinhVien(Parcel in) {
        id = in.readString();
        taikhoan = in.readString();
        matkhau = in.readString();
        hinhanh = in.readString();
    }

    public static final Creator<SinhVien> CREATOR = new Creator<SinhVien>() {
        @Override
        public SinhVien createFromParcel(Parcel in) {
            return new SinhVien(in);
        }

        @Override
        public SinhVien[] newArray(int size) {
            return new SinhVien[size];
        }
    };

    public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTaikhoan() {
return taikhoan;
}

public void setTaikhoan(String taikhoan) {
this.taikhoan = taikhoan;
}

public String getMatkhau() {
return matkhau;
}

public void setMatkhau(String matkhau) {
this.matkhau = matkhau;
}

public String getHinhanh() {
return hinhanh;
}

public void setHinhanh(String hinhanh) {
this.hinhanh = hinhanh;
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(id);
        dest.writeString(taikhoan);
        dest.writeString(matkhau);
        dest.writeString(hinhanh);
    }
}