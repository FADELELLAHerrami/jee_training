package IDao;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import Modele.Personne;
import Singleton.MyConnection;

public class DaoImpl implements DaoPaersonne<Personne>{

	@Override
	public Personne save(Personne obj) {

		Connection c= (Connection) MyConnection.getConnection();
		if(c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into personne(nom,prenom) values(?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, obj.getNom());
				ps.setString(2, obj.getPrenom());
				ps.executeUpdate();
				ResultSet rs = (ResultSet) ps.getGeneratedKeys();
				if(rs.next()) {
					obj.setNum(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return obj;
	}

	
	
}
