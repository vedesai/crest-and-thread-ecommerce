// AI Generated Code by Deloitte + Cursor (BEGIN)
import CategoryCard from './CategoryCard';
import type { Category } from '../../types';

// Sample category data based on Figma design
const categories: Category[] = [
  {
    id: 'women',
    name: "Women's Collection",
    itemCount: 256,
    image: 'https://images.unsplash.com/photo-1487412720507-e7ab37603c6f?w=500&h=600&fit=crop',
  },
  {
    id: 'men',
    name: "Men's Collection",
    itemCount: 184,
    image: 'https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=500&h=600&fit=crop',
  },
  {
    id: 'accessories',
    name: 'Accessories',
    itemCount: 92,
    image: 'https://images.unsplash.com/photo-1523779105320-d1cd346ff52b?w=500&h=600&fit=crop',
  },
];

function ShopByCategory() {
  return (
    <section className="bg-neutral-50 py-24 px-8">
      <div className="max-w-[1295px] mx-auto">
        {/* Section Header */}
        <div className="text-center mb-12">
          <p className="font-display font-semibold text-label text-accent uppercase tracking-wider mb-2">
            Explore
          </p>
          <h2 className="font-display font-normal text-display-lg text-primary">
            Shop by Category
          </h2>
        </div>

        {/* Categories Grid */}
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
          {categories.map((category) => (
            <CategoryCard key={category.id} category={category} />
          ))}
        </div>
      </div>
    </section>
  );
}

export default ShopByCategory;
// AI Generated Code by Deloitte + Cursor (END)
