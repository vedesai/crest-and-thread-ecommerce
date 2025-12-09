// AI Generated Code by Deloitte + Cursor (BEGIN)
import type { Category } from '../../types';

interface CategoryCardProps {
  category: Category;
}

function CategoryCard({ category }: CategoryCardProps) {
  return (
    <a
      href={`/category/${category.id}`}
      className="group relative block overflow-hidden rounded-xl aspect-[4/5]"
    >
      {/* Background Image */}
      <img
        src={category.image}
        alt={category.name}
        className="absolute inset-0 w-full h-full object-cover object-center transition-transform duration-700 group-hover:scale-110"
      />

      {/* Gradient Overlay */}
      <div className="absolute inset-0 bg-gradient-to-t from-black/60 via-transparent to-transparent" />

      {/* Content */}
      <div className="absolute bottom-6 left-6 text-white">
        <h3 className="font-display font-medium text-display-md mb-2">
          {category.name}
        </h3>
        <p className="font-body text-body-sm text-white/90">
          {category.itemCount} Items
        </p>
      </div>

      {/* Hover Overlay */}
      <div className="absolute inset-0 bg-primary/20 opacity-0 group-hover:opacity-100 transition-opacity duration-300" />
    </a>
  );
}

export default CategoryCard;
// AI Generated Code by Deloitte + Cursor (END)
