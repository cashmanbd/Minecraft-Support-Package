#!/usr/bin/perl
use strict;
use warnings;
 
my $file = $ARGV[0] or die "Need to get filename on the command line\n";
 
open(my $data, '<', $file) or die "Could not open '$file' $!\n";
 
while (my $line = <$data>) {
  chomp $line;
  my $start = index($line, ':');
  if ( $start != -1) {
  	my $value = substr($line, $start + 1, (length $line) - $start);
  	my @array1 = split ' ', $value;

  	my $block_type = $array1[0];
    print "$block_type, ";
  }
}