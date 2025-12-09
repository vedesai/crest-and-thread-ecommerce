// AI Generated Code by Deloitte + Cursor (BEGIN)
import { Button } from '../common';
import ProductCard from './ProductCard';
import type { Product } from '../../types';

// Sample product data based on Figma design
const products: Product[] = [
  {
    id: '1',
    name: 'Cashmere Crew Sweater',
    category: 'Knitwear',
    price: 189,
    image: 'https://images.unsplash.com/photo-1434389677669-e08b4cac3105?w=400&h=500&fit=crop',
    isNew: true,
  },
  {
    id: '2',
    name: 'Tailored Wool Coat',
    category: 'Outerwear',
    price: 349,
    image: 'https://images.unsplash.com/photo-1539533018447-63fcce2678e3?w=400&h=500&fit=crop',
    isNew: true,
  },
  {
    id: '3',
    name: 'Classic White Tee',
    category: 'Essentials',
    price: 45,
    image: 'https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=400&h=500&fit=crop',
    isNew: false,
  },
  {
    id: '4',
    name: 'Selvedge Denim Jeans',
    category: 'Denim',
    price: 168,
    image: 'https://images.unsplash.com/photo-1542272604-787c3835535d?w=400&h=500&fit=crop',
    isNew: false,
  },
];

function NewArrivals() {
  const handleAddToCart = (productId: string) => {
    console.log('Add to cart:', productId);
  };

  const handleAddToWishlist = (productId: string) => {
    console.log('Add to wishlist:', productId);
  };

  return (
    <section className="bg-white py-24 px-8">
      <div className="max-w-[1295px] mx-auto">
        {/* Section Header */}
        <div className="text-center mb-16">
          <p className="font-display font-semibold text-label text-accent uppercase tracking-wider mb-2">
            Curated Selection
          </p>
          <h2 className="font-display font-normal text-display-lg text-primary mb-4">
            New Arrivals
          </h2>
          <p className="font-body text-body text-neutral-500 max-w-2xl mx-auto">
            Discover our latest pieces, thoughtfully crafted to elevate your everyday wardrobe.
          </p>
        </div>

        {/* Products Grid */}
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-8 mb-16">
          {products.map((product) => (
            <ProductCard
              key={product.id}
              product={product}
              onAddToCart={handleAddToCart}
              onAddToWishlist={handleAddToWishlist}
            />
          ))}
        </div>

        {/* View All Button */}
        <div className="text-center">
          <Button variant="secondary" size="md">
            View All Products
          </Button>
        </div>
      </div>
    </section>
  );
}

export default NewArrivals;
// AI Generated Code by Deloitte + Cursor (END)
