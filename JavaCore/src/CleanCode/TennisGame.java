package CleanCode;

public class TennisGame {

    public static final int KHONG_DIEM = 0;
    public static final int MOT_DIEM = 1;
    public static final int HAI_DIEM = 2;
    public static final int BA_DIEM = 3;

    public static String tinhDiemHaiNguoiChoi(String tenNguoiChoi1, String tenNguoiChoi2, int diemNguoiChoi1, int diemNguoiChoi2) {
        String tenGoiDiemSo = "";
        int diemSoTamThoi = KHONG_DIEM;
        if (diemNguoiChoi1 == diemNguoiChoi2) {
            tenGoiDiemSo = xetDiemKhiHoa(diemNguoiChoi1);
        } else if (diemNguoiChoi1 >= 4 || diemNguoiChoi2 >= 4) {
            tenGoiDiemSo = xetDiemKhiCoLoiThe(diemNguoiChoi1, diemNguoiChoi2);
        } else {
            tenGoiDiemSo = xetDiem(diemNguoiChoi1, diemNguoiChoi2, tenGoiDiemSo);
        }
        return tenGoiDiemSo;
    }

    private static String xetDiem(int diemNguoiChoi1, int diemNguoiChoi2, String cach_Goi_Diem) {
        int diemSoTamThoi;
        for (int i = MOT_DIEM; i < BA_DIEM; i++) {
            if (i == MOT_DIEM) diemSoTamThoi = diemNguoiChoi1;
            else {
                cach_Goi_Diem += "-";
                diemSoTamThoi = diemNguoiChoi2;
            }
            switch (diemSoTamThoi) {
                case KHONG_DIEM:
                    cach_Goi_Diem += "Love";

                    break;
                case MOT_DIEM:
                    cach_Goi_Diem += "Fifteen";
                    break;
                case HAI_DIEM:
                    cach_Goi_Diem += "Thirty";

                    break;
                case BA_DIEM:
                    cach_Goi_Diem += "Forty";
                    break;
            }
        }
        return cach_Goi_Diem;
    }

    private static String xetDiemKhiCoLoiThe(int diemNguoiChoi1, int diemNguoiChoi2) {
        String cach_Goi_Diem;
        int hieu_so_diem = diemNguoiChoi1 - diemNguoiChoi2;
        if (hieu_so_diem == MOT_DIEM) cach_Goi_Diem = "Advantage player1";
        else if (hieu_so_diem == -MOT_DIEM) cach_Goi_Diem = "Advantage player2";
        else if (hieu_so_diem >= HAI_DIEM) cach_Goi_Diem = "Win for player1";
        else cach_Goi_Diem = "Win for player2";
        return cach_Goi_Diem;
    }

    private static String xetDiemKhiHoa(int diemNguoiChoi) {
        String cach_Goi_Diem;
        switch (diemNguoiChoi) {
            case KHONG_DIEM:
                cach_Goi_Diem = "Love-All";
                break;
            case MOT_DIEM:
                cach_Goi_Diem = "Fifteen-All";
                break;
            case HAI_DIEM:
                cach_Goi_Diem = "Thirty-All";
                break;
            case BA_DIEM:
                cach_Goi_Diem = "Forty-All";
                break;
            default:
                cach_Goi_Diem = "Deuce";
                break;

        }
        return cach_Goi_Diem;
    }
}
