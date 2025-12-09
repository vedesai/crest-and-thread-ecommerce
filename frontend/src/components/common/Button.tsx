// AI Generated Code by Deloitte + Cursor (BEGIN)
import { ButtonHTMLAttributes, forwardRef } from 'react';

interface ButtonProps extends ButtonHTMLAttributes<HTMLButtonElement> {
  variant?: 'primary' | 'secondary' | 'accent';
  size?: 'sm' | 'md' | 'lg';
}

const Button = forwardRef<HTMLButtonElement, ButtonProps>(
  ({ children, variant = 'primary', size = 'md', className = '', ...props }, ref) => {
    const baseStyles = 'inline-flex items-center justify-center font-medium uppercase tracking-wider rounded transition-all duration-200 font-body';
    
    const variants = {
      primary: 'bg-primary text-white hover:bg-primary-light',
      secondary: 'border border-primary text-primary hover:bg-primary hover:text-white',
      accent: 'bg-accent text-white hover:bg-accent-light shadow-button',
    };
    
    const sizes = {
      sm: 'px-6 py-3 text-xs',
      md: 'px-10 py-4 text-sm',
      lg: 'px-12 py-5 text-sm',
    };
    
    return (
      <button
        ref={ref}
        className={`${baseStyles} ${variants[variant]} ${sizes[size]} ${className}`}
        {...props}
      >
        {children}
      </button>
    );
  }
);

Button.displayName = 'Button';

export default Button;
// AI Generated Code by Deloitte + Cursor (END)
