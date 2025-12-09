// AI Generated Code by Deloitte + Cursor (BEGIN)
/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        // Brand Colors from Figma
        primary: {
          DEFAULT: '#1a1a1a',
          light: '#333333',
        },
        accent: {
          DEFAULT: '#c9a66b',
          light: '#d4b77c',
          dark: '#8b7355',
        },
        neutral: {
          50: '#f8f7f5',
          100: '#f1f0ee',
          200: '#e5e5e5',
          300: '#d4d4d4',
          400: '#a3a3a3',
          500: '#6b6b6b',
          600: '#525252',
          700: '#404040',
          800: '#262626',
          900: '#1a1a1a',
        },
      },
      fontFamily: {
        display: ['"Playfair Display"', 'Georgia', 'serif'],
        body: ['Inter', 'system-ui', 'sans-serif'],
      },
      fontSize: {
        'display-xl': ['56px', { lineHeight: '67.2px', letterSpacing: '-1.12px' }],
        'display-lg': ['40px', { lineHeight: '48px', letterSpacing: '-0.4px' }],
        'display-md': ['28px', { lineHeight: '33.6px' }],
        'display-sm': ['24px', { lineHeight: '24px' }],
        'heading': ['20px', { lineHeight: '20px', letterSpacing: '1px' }],
        'subheading': ['16px', { lineHeight: '19.2px' }],
        'label': ['14px', { lineHeight: '16.8px', letterSpacing: '1.4px' }],
        'body-lg': ['18px', { lineHeight: '28px' }],
        'body': ['16px', { lineHeight: '27.2px' }],
        'body-sm': ['14px', { lineHeight: '20px' }],
        'caption': ['12px', { lineHeight: '16px', letterSpacing: '0.6px' }],
      },
      borderRadius: {
        'pill': '9999px',
      },
      boxShadow: {
        'card': '0px 25px 50px -12px rgba(0, 0, 0, 0.25)',
        'button': '0px 10px 15px -3px rgba(0, 0, 0, 0.1), 0px 4px 6px -4px rgba(0, 0, 0, 0.1)',
      },
    },
  },
  plugins: [],
}
// AI Generated Code by Deloitte + Cursor (END)
