// AI Generated Code by Deloitte + Cursor (BEGIN)
import { Button } from '../common';

// About image from design
const aboutImage = 'https://images.unsplash.com/photo-1558171813-4c088753af8f?w=700&h=500&fit=crop';

function AboutUs() {
  return (
    <section className="bg-white py-24 px-8">
      <div className="max-w-[1295px] mx-auto">
        <div className="grid grid-cols-1 lg:grid-cols-2 gap-16 items-center">
          {/* Content */}
          <div className="max-w-[615px]">
            <p className="font-display font-semibold text-label text-accent uppercase tracking-wider mb-4">
              Our Story
            </p>
            <h2 className="font-display font-normal text-display-lg text-primary mb-8">
              Crafted with Purpose
            </h2>
            <div className="space-y-6 mb-10">
              <p className="font-body text-body text-neutral-500 leading-relaxed">
                At Crest & Thread, we believe in creating apparel that stands the test of time. 
                Each piece is carefully designed with attention to detail, using premium materials 
                and traditional craftsmanship techniques.
              </p>
              <p className="font-body text-body text-neutral-500 leading-relaxed">
                Our commitment to quality and sustainability means you can feel good about 
                every purchase, knowing it was made with care for both people and planet.
              </p>
            </div>
            <Button variant="primary" size="md">
              Learn More About Us
            </Button>
          </div>

          {/* Image */}
          <div className="relative">
            <img
              src={aboutImage}
              alt="Crest & Thread craftsmanship"
              className="w-full rounded-xl shadow-card object-cover aspect-[3/2]"
            />
          </div>
        </div>
      </div>
    </section>
  );
}

export default AboutUs;
// AI Generated Code by Deloitte + Cursor (END)
