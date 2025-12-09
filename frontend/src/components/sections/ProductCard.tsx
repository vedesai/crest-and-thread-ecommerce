// AI Generated Code by Deloitte + Cursor (BEGIN)
import { useState } from 'react';
import { Icon } from '../common';
import type { Product } from '../../types';

interface ProductCardProps {
  product: Product;
  onAddToCart?: (productId: string) => void;
  onAddToWishlist?: (productId: string) => void;
}

function ProductCard({ product, onAddToCart, onAddToWishlist }: ProductCardProps) {
  const [isHovered, setIsHovered] = useState(false);

  const handleAddToCart = () => {
    onAddToCart?.(product.id);
  };

  const handleAddToWishlist = () => {
    onAddToWishlist?.(product.id);
  };

  return (
    <article
      className="group cursor-pointer"
      onMouseEnter={() => setIsHovered(true)}
      onMouseLeave={() => setIsHovered(false)}
    >
      {/* Image Container */}
      <div className="relative bg-neutral-50 rounded-lg overflow-hidden aspect-[3/4] mb-4">
        <img
          src={product.image}
          alt={product.name}
          className="w-full h-full object-cover object-center transition-transform duration-500 group-hover:scale-105"
        />

        {/* New Badge */}
        {product.isNew && (
          <span className="absolute top-4 left-4 bg-accent text-white text-caption font-body px-3 py-1 rounded-full">
            NEW
          </span>
        )}

        {/* Wishlist Button */}
        <button
          onClick={handleAddToWishlist}
          className={`absolute top-4 right-4 w-10 h-10 bg-white rounded-full flex items-center justify-center text-primary hover:text-accent transition-all duration-300 ${
            isHovered ? 'opacity-100 translate-y-0' : 'opacity-0 -translate-y-2'
          }`}
          aria-label="Add to wishlist"
        >
          <Icon name="heart" size={20} />
        </button>

        {/* Quick Add Button */}
        <button
          onClick={handleAddToCart}
          className={`absolute bottom-4 left-4 right-4 bg-primary text-white font-body font-medium text-sm uppercase tracking-wider py-4 rounded transition-all duration-300 hover:bg-primary-light ${
            isHovered ? 'opacity-100 translate-y-0' : 'opacity-0 translate-y-4'
          }`}
        >
          Quick Add
        </button>
      </div>

      {/* Product Info */}
      <div className="space-y-1">
        <p className="font-body text-caption text-neutral-500 uppercase tracking-wider">
          {product.category}
        </p>
        <h3 className="font-display font-semibold text-subheading text-primary">
          {product.name}
        </h3>
        <p className="font-body text-body text-accent-dark">
          ${product.price}
        </p>
      </div>
    </article>
  );
}

export default ProductCard;
// AI Generated Code by Deloitte + Cursor (END)
