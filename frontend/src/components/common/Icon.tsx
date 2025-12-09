// AI Generated Code by Deloitte + Cursor (BEGIN)
interface IconProps {
  name: 'search' | 'user' | 'cart' | 'heart' | 'instagram' | 'facebook' | 'twitter' | 'mail' | 'quality' | 'secure' | 'shipping';
  size?: number;
  className?: string;
}

function Icon({ name, size = 20, className = '' }: IconProps) {
  const icons: Record<string, JSX.Element> = {
    search: (
      <svg width={size} height={size} viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
        <circle cx="9" cy="9" r="6" stroke="currentColor" strokeWidth="2"/>
        <path d="M13.5 13.5L17 17" stroke="currentColor" strokeWidth="2" strokeLinecap="round"/>
      </svg>
    ),
    user: (
      <svg width={size} height={size} viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
        <circle cx="10" cy="6" r="4" stroke="currentColor" strokeWidth="2"/>
        <path d="M3 18C3 14.134 6.13401 11 10 11C13.866 11 17 14.134 17 18" stroke="currentColor" strokeWidth="2" strokeLinecap="round"/>
      </svg>
    ),
    cart: (
      <svg width={size} height={size} viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M4 4H5.5L8 14H15L17 6H6" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/>
        <circle cx="8" cy="17" r="1.5" fill="currentColor"/>
        <circle cx="14" cy="17" r="1.5" fill="currentColor"/>
      </svg>
    ),
    heart: (
      <svg width={size} height={size} viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M10 17L8.55 15.7C4.4 12.1 2 9.95 2 7.35C2 5.2 3.8 3.5 6 3.5C7.25 3.5 8.45 4.05 10 5.5C11.55 4.05 12.75 3.5 14 3.5C16.2 3.5 18 5.2 18 7.35C18 9.95 15.6 12.1 11.45 15.7L10 17Z" stroke="currentColor" strokeWidth="2"/>
      </svg>
    ),
    instagram: (
      <svg width={size} height={size} viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
        <rect x="1" y="1" width="14" height="14" rx="4" stroke="currentColor" strokeWidth="1.5"/>
        <circle cx="8" cy="8" r="3" stroke="currentColor" strokeWidth="1.5"/>
        <circle cx="12" cy="4" r="1" fill="currentColor"/>
      </svg>
    ),
    facebook: (
      <svg width={size} height={size} viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M10 2H12V5H10C9.44772 5 9 5.44772 9 6V8H12L11.5 11H9V15H6V11H4V8H6V6C6 3.79086 7.79086 2 10 2Z" stroke="currentColor" strokeWidth="1.5" strokeLinejoin="round"/>
      </svg>
    ),
    twitter: (
      <svg width={size} height={size} viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M2 12C3.5 12.5 5 12.5 6.5 12C8.5 11.3 10 9.5 10 7V6.5C10.5 6 11 5.5 11.5 4.5C11 4.8 10.5 5 10 5C10.5 4.5 11 4 11.5 3C11 3.3 10.5 3.5 10 3.5C9.5 3 8.5 2.5 7.5 2.5C5.5 2.5 4 4 4 6V7C2.5 7 1.5 6 1 5C1 7 2 9 4 10C3 10.5 2 10.5 1 10.5C1.5 11.5 2 12 2 12Z" stroke="currentColor" strokeWidth="1.5" strokeLinejoin="round"/>
      </svg>
    ),
    mail: (
      <svg width={size} height={size} viewBox="0 0 48 48" fill="none" xmlns="http://www.w3.org/2000/svg">
        <rect x="4" y="8" width="40" height="32" rx="4" stroke="currentColor" strokeWidth="3"/>
        <path d="M4 12L24 28L44 12" stroke="currentColor" strokeWidth="3"/>
      </svg>
    ),
    quality: (
      <svg width={size} height={size} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M16 2L20 10L28 11L22 17L24 26L16 22L8 26L10 17L4 11L12 10L16 2Z" stroke="currentColor" strokeWidth="2" strokeLinejoin="round"/>
      </svg>
    ),
    secure: (
      <svg width={size} height={size} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
        <rect x="6" y="12" width="20" height="16" rx="2" stroke="currentColor" strokeWidth="2"/>
        <path d="M10 12V8C10 4.68629 12.6863 2 16 2C19.3137 2 22 4.68629 22 8V12" stroke="currentColor" strokeWidth="2"/>
        <circle cx="16" cy="20" r="2" fill="currentColor"/>
      </svg>
    ),
    shipping: (
      <svg width={size} height={size} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
        <rect x="2" y="8" width="18" height="16" rx="1" stroke="currentColor" strokeWidth="2"/>
        <path d="M20 12H26L30 18V24H20V12Z" stroke="currentColor" strokeWidth="2" strokeLinejoin="round"/>
        <circle cx="8" cy="26" r="3" stroke="currentColor" strokeWidth="2"/>
        <circle cx="24" cy="26" r="3" stroke="currentColor" strokeWidth="2"/>
      </svg>
    ),
  };

  return (
    <span className={`inline-flex items-center justify-center ${className}`}>
      {icons[name]}
    </span>
  );
}

export default Icon;
// AI Generated Code by Deloitte + Cursor (END)
