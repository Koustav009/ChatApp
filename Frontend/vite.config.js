import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/rooms': {  // Forward API requests to the backend
        target: 'http://localhost:8080',  // Your Spring Boot backend URL
        changeOrigin: true,
        secure: false,  // Disable SSL verification if using HTTPS locally
      },
    },
  },
});