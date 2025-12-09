// AI Generated Code by Deloitte + Cursor (BEGIN)
import { Icon } from '../common';
import type { Feature } from '../../types';

const features: Feature[] = [
  {
    id: 'quality',
    title: 'Premium Quality',
    description: 'Meticulously crafted using the finest materials for lasting wear.',
    icon: 'quality',
  },
  {
    id: 'secure',
    title: 'Secure Checkout',
    description: 'Safe and secure payment processing for peace of mind.',
    icon: 'secure',
  },
  {
    id: 'shipping',
    title: 'Free Shipping',
    description: 'Complimentary shipping on all orders over $150.',
    icon: 'shipping',
  },
];

function Features() {
  return (
    <section className="bg-primary py-24 px-8">
      <div className="max-w-[1295px] mx-auto">
        <div className="grid grid-cols-1 md:grid-cols-3 gap-12">
          {features.map((feature) => (
            <div key={feature.id} className="text-center">
              {/* Icon */}
              <div className="flex justify-center mb-6">
                <div className="w-16 h-16 bg-accent rounded-full flex items-center justify-center text-white">
                  <Icon name={feature.icon as 'quality' | 'secure' | 'shipping'} size={32} />
                </div>
              </div>
              
              {/* Title */}
              <h3 className="font-display font-semibold text-display-sm text-white mb-4">
                {feature.title}
              </h3>
              
              {/* Description */}
              <p className="font-body text-body text-white/80 max-w-sm mx-auto">
                {feature.description}
              </p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}

export default Features;
// AI Generated Code by Deloitte + Cursor (END)
