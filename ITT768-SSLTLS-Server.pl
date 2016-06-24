/**
 * @author Name  :rizakinapi - 2014585361
 * ITT768 : NetProgramming
 */

use strict;
use warnings;
use IO::Socket::SSL;

$| = 1;

# Create Socket For Listening
my $socket = new IO::Socket::SSL (
LocalHost => '0.0.0.0',
LocalPort => '8822',
Listen => 5,
Reuse => 1,
SSL_cert_file => 'rizaki.itt768.com.crt',
SSL_key_file => 'rizaki.itt768.com',
);
die "Socket Not Created $!\n" unless $socket;
print "Begin ITT768-Netprogramming Assignment 2 using Perl by Rizaki Napi\nServer waiting for client connection on port 8822\n";

# Waiting New SSL Client Connection
my $Client = $socket->accept() or die "SSL_ERROR = $SSL_ERROR\n";

# Get Newly Connected SSL Client Information
my $Client_Address = $Client->peerhost();
my $Client_Port = $Client->peerport();
print "New connection from $Client_Address:$Client_Port\n";

# read from the connected client
my $Data = "";
$client->read($Data);
print "Received Message: $Data";

print "End\n";
shutdown($Client, 1);
