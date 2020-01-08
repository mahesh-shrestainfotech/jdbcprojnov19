import java.util.List;

import com.dao.ProductDAOImpl;
import com.vo.Product;

public class TestDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductDAOImpl daoImpl = new ProductDAOImpl();

		List<Product> products = daoImpl.findAllProducts();

		for (Product product : products) {
			System.out.println(product);
		}

	}

}
