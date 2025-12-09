// AI Generated Code by Deloitte + Cursor (BEGIN)
interface LogoProps {
  variant?: 'dark' | 'light';
  size?: 'sm' | 'md' | 'lg';
}

function Logo({ variant = 'dark', size = 'md' }: LogoProps) {
  const textColor = variant === 'dark' ? 'text-primary' : 'text-white';
  
  const sizes = {
    sm: { icon: 'w-6 h-6', text: 'text-base' },
    md: { icon: 'w-8 h-8', text: 'text-xl' },
    lg: { icon: 'w-10 h-10', text: 'text-2xl' },
  };

  return (
    <a href="/" className="flex items-center gap-3">
      {/* Logo Icon - Stylized Thread/Needle */}
      <div className={`${sizes[size].icon} relative`}>
        <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
          <circle 
            cx="20" 
            cy="20" 
            r="18" 
            stroke="currentColor" 
            strokeWidth="2" 
            className={textColor}
          />
          <path 
            d="M20 8C20 8 12 16 12 22C12 26.4183 15.5817 30 20 30C24.4183 30 28 26.4183 28 22C28 16 20 8 20 8Z" 
            fill="currentColor"
            className="text-accent"
          />
        </svg>
      </div>
      {/* Logo Text */}
      <span className={`font-display font-medium tracking-wider ${sizes[size].text} ${textColor}`}>
        Crest & Thread
      </span>
    </a>
  );
}

export default Logo;
// AI Generated Code by Deloitte + Cursor (END)
