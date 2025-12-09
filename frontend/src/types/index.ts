// AI Generated Code by Deloitte + Cursor (BEGIN)
export interface Product {
  id: string;
  name: string;
  category: string;
  price: number;
  image: string;
  isNew?: boolean;
}

export interface Category {
  id: string;
  name: string;
  itemCount: number;
  image: string;
}

export interface NavLink {
  label: string;
  href: string;
}

export interface FooterLink {
  label: string;
  href: string;
}

export interface FooterSection {
  title: string;
  links: FooterLink[];
}

export interface Feature {
  id: string;
  title: string;
  description: string;
  icon: string;
}
// AI Generated Code by Deloitte + Cursor (END)
