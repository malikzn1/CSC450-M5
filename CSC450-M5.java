#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>

void reverseFileContent(const std::string& inputFileName, const std::string& outputFileName) {
    std::ifstream inputFile(inputFileName);
    if (!inputFile) {
        std::cerr << "Error: Could not open the input file.\n";
        return;
    }

    // Read the entire file content into a string
    std::string content((std::istreambuf_iterator<char>(inputFile)),
    (std::istreambuf_iterator<char>()));
    inputFile.close();

    // Reverse the content
    std::reverse(content.begin(), content.end());

    // Write the reversed content to the output file
    std::ofstream outputFile(outputFileName);
    if (!outputFile) {
        std::cerr << "Error: Could not open the output file.\n";
        return;
    }
    outputFile << content;
    outputFile.close();
}

int main() {
    const std::string inputFileName = "CSC450_CT5_mod5.txt";
    const std::string outputFileName = "CSC450-mod5-reverse.txt";

    // Step 1: Append user input to the file
    std::ofstream outFile(inputFileName, std::ios::app);
    if (!outFile) {
        std::cerr << "Error: Could not open the file for appending.\n";
        return 1;
    }

    std::string userInput;
    std::cout << "Enter the text to append to the file: ";
    std::getline(std::cin, userInput);

    outFile << userInput << "\n";
    outFile.close();

    // Step 2: Reverse the file content and write to another file
    reverseFileContent(inputFileName, outputFileName);

    std::cout << "Operation completed. Check the files for results.\n";

    return 0;
}
