// AI Generated Code by Deloitte + Cursor (BEGIN)
import { Button } from '../common';

// Hero image from Figma design
const heroImage = "https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=1400&h=900&fit=crop";

function Hero() {
  return (
    <section className="relative h-screen min-h-[700px] max-h-[900px] overflow-hidden">
      {/* Background Image */}
      <div className="absolute inset-0">
        <img
          src={heroImage}
          alt="Fashion collection showcase"
          className="w-full h-full object-cover object-center"
        />
        {/* Overlay */}
        <div className="absolute inset-0 bg-black/30" />
      </div>

      {/* Content */}
      <div className="relative z-10 flex items-center justify-center h-full px-8">
        <div className="max-w-[960px] text-center">
          {/* Label */}
          <p className="font-display font-semibold text-label text-accent uppercase tracking-wider mb-4">
            Winter Collection 2025
          </p>

          {/* Heading */}
          <h1 className="font-display font-normal text-4xl md:text-5xl lg:text-display-xl text-primary mb-6 leading-tight">
            Timeless Elegance Meets Modern Craftsmanship
          </h1>

          {/* Subheading */}
          <p className="font-body text-body-lg text-white/90 max-w-2xl mx-auto mb-10">
            Discover our curated collection of premium apparel, designed for those who appreciate quality and style.
          </p>

          {/* CTA Buttons */}
          <div className="flex flex-col sm:flex-row items-center justify-center gap-4">
            <Button variant="primary" size="md">
              Shop Now
            </Button>
            <Button variant="secondary" size="md">
              Explore Collections
            </Button>
          </div>
        </div>
      </div>

      {/* Style Guide Button (from design) */}
      <button className="absolute right-8 top-[calc(100vh-180px)] bg-accent text-white font-body text-base px-6 py-3 rounded-full shadow-button hover:bg-accent-light transition-colors">
        View Style Guide
      </button>
    </section>
  );
}

export default Hero;
// AI Generated Code by Deloitte + Cursor (END)
