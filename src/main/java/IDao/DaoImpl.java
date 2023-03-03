package IDao;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public Boolean existPersonne(int id) {
		// TODO Auto-generated method stub
		List<Integer> ids = new ArrayList<Integer>();
		Connection c= (Connection) MyConnection.getConnection();
		if(c != null) {			
			try {
				PreparedStatement ps = c.prepareStatement("select num from personne");
				ResultSet rs = (ResultSet) ps.executeQuery();
				while(rs.next()) {
					ids.add(rs.getInt("num"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ids.contains(id)) return true;
		else return false;
	}
	
	

	@Override
	public Personne update(int id, String nom, String prenom) {
		// TODO Auto-generated method stub
		Connection c= (Connection) MyConnection.getConnection();
		Personne p = new Personne();
		p.setNum(id);
		if(c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("update personne set nom=?,prenom=?,where id =?");
				ps.setString(1,nom);
				ps.setString(2,prenom);
				ps.setInt(3,id);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	

	
	
}


















