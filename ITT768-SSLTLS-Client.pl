/**
 * @author Name  :rizakinapi - 2014585361
 * ITT768 : NetProgramming
 */


use warnings;
use IO::Socket::SSL;
use Getopt::Long qw(:config posix_default bundling);

my $Address = 'localhost';
my $Port = '8822';

my $Client = IO::Socket::SSL-&gt;new(
    PeerAddress =&gt; $Address,
    PeerPort =&gt; $Port,
    SSL_version =&gt; 'TLSv1',    # To Use TLS Version 1
    SSL_verify_mode =&gt; 0,
) or die "failed to connect to $Address: $!,$SSL_ERROR";

# To View Detail Certificate Information
warn "New SSL connection with cipher=".$client-&gt;get_cipher." version=".$client-&gt;get_sslversion." certificate:\n".
    "\tsubject=".$client-&gt;peer_certificate('Subject')."\n".
    "\tissuer=".$client-&gt;peer_certificate('Issuer')."\n";


print "Enter message to send to the server: ";
my $Msg = &lt;STDIN&gt;;
# message to send to a server
print $client $Msg;

print "End\n";
shutdown($Client, 1);

