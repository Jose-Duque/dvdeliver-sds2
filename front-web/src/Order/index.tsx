import { useEffect, useState } from 'react';
import {} from 'react-router-dom';
import  './styles.css';
import StepsHeader from './StepsHeader';
import ProductsList from './ProductsList';
import { Product } from './types';
import { fetchProducts } from '../api';

const Order = () => {

  const [product, setProduct] = useState<Product[]>([]);

  useEffect(() => {
    fetchProducts()
      .then(response => setProduct(response.data))
      .catch(error => console.log(error))
  }, []);

  return (
    <>
      <div className="orders-container">
        <StepsHeader/>
        <ProductsList products={product} />
      </div>
    </>
  );
}

export default Order;
