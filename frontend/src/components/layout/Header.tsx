// AI Generated Code by Deloitte + Cursor (BEGIN)
import { useState } from 'react';
import { Logo, Icon } from '../common';
import type { NavLink } from '../../types';

const navLinks: NavLink[] = [
  { label: 'New Arrivals', href: '/new-arrivals' },
  { label: 'Men', href: '/men' },
  { label: 'Women', href: '/women' },
  { label: 'Collections', href: '/collections' },
  { label: 'Sale', href: '/sale' },
];

function Header() {
  const [cartCount] = useState(0);
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  return (
    <header className="fixed top-0 left-0 right-0 z-50 bg-white border-b border-neutral-200">
      <div className="max-w-[1359px] mx-auto px-8">
        <nav className="flex items-center justify-between h-20">
          {/* Logo */}
          <Logo size="md" variant="dark" />

          {/* Desktop Navigation */}
          <ul className="hidden md:flex items-center gap-8">
            {navLinks.map((link) => (
              <li key={link.href}>
                <a
                  href={link.href}
                  className="font-body text-base text-primary hover:text-accent transition-colors duration-200"
                >
                  {link.label}
                </a>
              </li>
            ))}
          </ul>

          {/* Icons */}
          <div className="flex items-center gap-4">
            {/* Search Button */}
            <button
              className="p-2 text-primary hover:text-accent transition-colors"
              aria-label="Search"
            >
              <Icon name="search" size={20} />
            </button>

            {/* User Button */}
            <button
              className="p-2 text-primary hover:text-accent transition-colors"
              aria-label="Account"
            >
              <Icon name="user" size={20} />
            </button>

            {/* Cart Button */}
            <button
              className="relative p-2 text-primary hover:text-accent transition-colors"
              aria-label="Cart"
            >
              <Icon name="cart" size={20} />
              <span className="absolute -top-0.5 right-0 flex items-center justify-center w-5 h-5 bg-accent-dark text-white text-xs font-body rounded-full">
                {cartCount}
              </span>
            </button>

            {/* Mobile Menu Button */}
            <button
              className="md:hidden p-2 text-primary"
              onClick={() => setIsMenuOpen(!isMenuOpen)}
              aria-label="Menu"
            >
              <svg
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                strokeWidth="2"
              >
                {isMenuOpen ? (
                  <path d="M6 18L18 6M6 6l12 12" />
                ) : (
                  <path d="M4 6h16M4 12h16M4 18h16" />
                )}
              </svg>
            </button>
          </div>
        </nav>

        {/* Mobile Menu */}
        {isMenuOpen && (
          <div className="md:hidden py-4 border-t border-neutral-200">
            <ul className="flex flex-col gap-4">
              {navLinks.map((link) => (
                <li key={link.href}>
                  <a
                    href={link.href}
                    className="block font-body text-base text-primary hover:text-accent transition-colors"
                  >
                    {link.label}
                  </a>
                </li>
              ))}
            </ul>
          </div>
        )}
      </div>
    </header>
  );
}

export default Header;
// AI Generated Code by Deloitte + Cursor (END)
