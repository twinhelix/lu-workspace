#include <fstream>
#include <iostream>
#include <boost/program_options.hpp>
#include <vector>
#include "ReadScript.hpp"

 namespace po = boost::program_options;

/*
The main program of the charging system
It reads a script with name on the command line
parsing the script  and performs the actions described
*/

int main(int argc, char *argv[]) {
    // Declare the supported options.
    // Using boost library command
    int script_count;
    bool doecho;
    
  
    // what kind of options
    po::command_line_style::style_t pstyle = po::command_line_style::style_t(
        po::command_line_style::unix_style |
        po::command_line_style::case_insensitive |
        po::command_line_style::allow_long_disguise ); 
  
    po::options_description desc("Allowed options");
    desc.add_options()
    ("help", "produce the help message")
    ("echo", "echo the script a command at a time")
    ("script-file",po::value<vector<string> >(), "script file name");
    
    po::positional_options_description pdesc;
    pdesc.add("script-file",-1);
    po::variables_map varmap;
    po::store(po::command_line_parser(argc, argv).style(pstyle).
              options(desc).positional(pdesc).run(),varmap);

    po::notify(varmap);

    if (varmap.count("help")) {
        cout << desc << "\n";
        return 0;
    }

    script_count = varmap.count("script-file");
    doecho  = varmap.count("echo")>0;

    if (script_count == 0 ) {
        std::cerr << "Give the name of a script as an argument to "
                  << argv[0] << endl;
        return 1;
    }
    if (script_count > 1 ) {
        cerr << "There should only be one script file to "
             << argv[0] << endl ;
        return 2;
    }
    vector<string> files(varmap["script-file"].as< vector<string> >() );
    string filename = files[0];
    ReadScript rs(filename,doecho);
    rs.readscript();

};
