package  com.ps.PS.service;
import java.util.List;
import com.ps.PS.model.AdminMod;
public interface AdminModService {
List< AdminMod > getAllAdminMods();
void saveAdminMod(AdminMod adminMod);
AdminMod getAdminModById(long id);
void deleteAdminModById(long id);
}
