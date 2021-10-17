package net.javaguides.springboot.service;
import java.util.List;
import net.javaguides.springboot.model.AdminMod;
public interface AdminModService {
List< AdminMod > getAllAdminMods();
void saveAdminMod(AdminMod adminMod);
AdminMod getAdminModById(long id);
void deleteAdminModById(long id);
}
