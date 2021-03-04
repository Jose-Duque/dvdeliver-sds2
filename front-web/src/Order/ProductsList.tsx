
import {} from 'react-router-dom';
import  './styles.css';
import ProductCard from './ProductCard';
import { Product } from './types';
import { checkIsSelected } from './helpers';

type Props = {
  products: Product[];
  selectedProducts: Product[];
  onSelectProduct: (product: Product) => void;
}

const ProductsList = ({products, onSelectProduct, selectedProducts }: Props) => {
  return (
    <>
      <div className="orders-list-container">
        <div className="orders-list-items">
          {products.map(prod => (
            <ProductCard 
              key={prod.id} 
              product={prod}
              onSelectProduct={onSelectProduct}
              isSelected={checkIsSelected(selectedProducts, prod)}
            />
          ))}
        </div>
      </div>
    </>
  );
}

export default ProductsList;