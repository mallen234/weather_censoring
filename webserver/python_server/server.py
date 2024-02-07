from http.server import BaseHTTPRequestHandler, HTTPServer
from urllib.parse import urlparse, parse_qs
import logging

# Set up logging
logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

class RequestHandler(BaseHTTPRequestHandler):
    def log_request(self, code='-', size='-'):
        # Override the default log_request method to suppress logging of each request
        pass

    def do_GET(self):
        # Parse the request URL
        parsed_url = urlparse(self.path)
        query_params = parse_qs(parsed_url.query)

        # Log the request
        logger.info(f"Received GET request from {self.client_address[0]} for path {parsed_url.path}")
        logger.info(f"Query parameters: {query_params}")

        # Send a response back to the client
        self.send_response(200)
        self.send_header('Content-type', 'text/plain')
        self.end_headers()
        self.wfile.write(b'Received your GET request!\n')

def run_server(port=8080):
    server_address = ("192.168.1.164", port)
    httpd = HTTPServer(server_address, RequestHandler)
    logger.info(f'Starting server on port {port}')
    try:
        httpd.serve_forever()
    except KeyboardInterrupt:
        pass
    httpd.server_close()
    logger.info('Server stopped')

if __name__ == '__main__':
    run_server()
