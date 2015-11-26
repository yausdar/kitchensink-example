package business.report;

import java.util.List;

import javax.ejb.Stateless;

import model.entity.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Stateless
public class ReportUsuario {

	public void generate(List<Usuario> listaUsuario) {
		try {
			JasperReport report = JasperCompileManager
					.compileReport("/reportUsuario.jrxml");
			JasperPrint print = JasperFillManager.fillReport(report, null,
					new JRBeanCollectionDataSource(listaUsuario));
			JasperExportManager.exportReportToPdfFile(print, "C:/reportUsuario.pdf");
		} catch (JRException e) {
			e.printStackTrace();
		}

	}

}
