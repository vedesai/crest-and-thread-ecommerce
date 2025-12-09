// AI Generated Code by Deloitte + Cursor (BEGIN)
import { useState } from 'react';
import { Logo, Icon, Button } from '../common';
import type { FooterSection } from '../../types';

const footerSections: FooterSection[] = [
  {
    title: 'Shop',
    links: [
      { label: 'New Arrivals', href: '/new-arrivals' },
      { label: 'Men', href: '/men' },
      { label: 'Women', href: '/women' },
      { label: 'Collections', href: '/collections' },
      { label: 'Sale', href: '/sale' },
    ],
  },
  {
    title: 'Support',
    links: [
      { label: 'Contact Us', href: '/contact' },
      { label: 'Shipping Info', href: '/shipping' },
      { label: 'Returns', href: '/returns' },
      { label: 'Size Guide', href: '/size-guide' },
      { label: 'FAQ', href: '/faq' },
    ],
  },
  {
    title: 'Company',
    links: [
      { label: 'About Us', href: '/about' },
      { label: 'Careers', href: '/careers' },
      { label: 'Sustainability', href: '/sustainability' },
      { label: 'Press', href: '/press' },
      { label: 'Privacy', href: '/privacy' },
    ],
  },
];

const socialLinks = [
  { name: 'instagram', href: 'https://instagram.com' },
  { name: 'facebook', href: 'https://facebook.com' },
  { name: 'twitter', href: 'https://twitter.com' },
];

function Footer() {
  const [email, setEmail] = useState('');

  const handleNewsletterSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    console.log('Newsletter subscription:', email);
    setEmail('');
  };

  return (
    <footer className="bg-neutral-50 border-t border-neutral-200">
      {/* Main Footer Content */}
      <div className="max-w-[1359px] mx-auto px-8 pt-24">
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-5 gap-12 mb-16">
          {/* Brand Column */}
          <div className="lg:col-span-2">
            <Logo size="lg" variant="dark" />
            <p className="font-body text-body text-neutral-500 mt-6 max-w-sm leading-relaxed">
              Crafting timeless apparel with attention to detail and quality. 
              Elevate your wardrobe with pieces designed to last.
            </p>
            
            {/* Social Links */}
            <div className="flex gap-4 mt-8">
              {socialLinks.map((social) => (
                <a
                  key={social.name}
                  href={social.href}
                  target="_blank"
                  rel="noopener noreferrer"
                  className="w-10 h-10 border border-neutral-200 rounded-full flex items-center justify-center text-neutral-500 hover:text-primary hover:border-primary transition-colors"
                  aria-label={social.name}
                >
                  <Icon name={social.name as 'instagram' | 'facebook' | 'twitter'} size={16} />
                </a>
              ))}
            </div>
          </div>

          {/* Link Columns */}
          {footerSections.map((section) => (
            <div key={section.title}>
              <h4 className="font-display font-semibold text-subheading text-primary mb-6">
                {section.title}
              </h4>
              <ul className="space-y-3">
                {section.links.map((link) => (
                  <li key={link.href}>
                    <a
                      href={link.href}
                      className="font-body text-body text-neutral-500 hover:text-primary transition-colors"
                    >
                      {link.label}
                    </a>
                  </li>
                ))}
              </ul>
            </div>
          ))}
        </div>

        {/* Newsletter Section */}
        <div className="border-t border-neutral-200 py-16">
          <div className="max-w-xl mx-auto text-center">
            <div className="flex justify-center mb-4">
              <Icon name="mail" size={48} className="text-primary" />
            </div>
            <h3 className="font-display font-medium text-display-md text-primary mb-4">
              Join Our Newsletter
            </h3>
            <p className="font-body text-body text-neutral-500 mb-8">
              Subscribe to receive updates on new arrivals, special offers, and style inspiration.
            </p>
            <form onSubmit={handleNewsletterSubmit} className="flex gap-3">
              <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                placeholder="Enter your email"
                className="flex-1 px-4 py-4 border border-neutral-200 rounded font-body text-base text-primary placeholder:text-primary/50 focus:outline-none focus:border-accent transition-colors"
                required
              />
              <Button type="submit" variant="primary" size="md">
                Subscribe
              </Button>
            </form>
          </div>
        </div>

        {/* Copyright */}
        <div className="border-t border-neutral-200 py-8">
          <p className="font-body text-body text-neutral-500 text-center">
            © 2025 Crest & Thread. All rights reserved.
          </p>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
// AI Generated Code by Deloitte + Cursor (END)
