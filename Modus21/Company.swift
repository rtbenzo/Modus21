import CoreLocation
import Foundation

enum Company {
    static let name = "Modus21"
    static let legalName = "Modus21, LLC"
    static let kicker = "Defense Technology Solutions"
    static let tagline = "Delivering Technology Solutions for Mission Success"
    static let hero = "Since 2004, Modus21 has provided reliable, high-quality technology services to the U.S. Department of War and our nation's warfighters."
    static let aboutTitle = "Two Decades of Mission-Focused Excellence"
    static let about = [
        "Modus21 is a small business based in Charleston, South Carolina. For over twenty years, we have supported critical defense missions through specialized expertise in Agile Software Development, Cloud Computing, Artificial Intelligence, Systems Integration, Model Based Systems Engineering, Business Process Re-engineering, Cybersecurity, and DevSecOps.",
        "We combine deep domain knowledge with disciplined execution to help our customers solve complex technical challenges in secure environments."
    ]
    static let valuesIntro = "These values drive all of our decisions and activities. They keep us focused on disciplined execution, trusted partnerships, and dedication to the mission."
    static let capabilitiesIntro = "We deliver end-to-end technology solutions tailored to the unique demands of defense and national security environments."
    static let experienceTitle = "A Proven Partner to Defense Leaders"
    static let experience = [
        "Modus21 is a trusted partner to the Department of War and leading defense contractors. Our team maintains the highest standards of performance and compliance.",
        "We are proud to support programs at NIWC Atlantic and other critical naval and joint initiatives."
    ]
    static let cultureTitle = "Culture"
    static let culture = "Our leadership is committed to maintaining a company that fosters innovation, professionalism, and an entrepreneurial spirit. Modus21 provides an open forum for communication and collaboration. We believe that our success is achieved through teamwork and that every employee's opinion is invaluable. We maintain an environment that rewards our employees for their performance and contributions to the success of our clients. Our team members are encouraged to participate in wellness initiatives and various company-sponsored functions throughout the year."
    static let careersPrompt = "If you would like more information on joining the Modus21 team, please contact us at careers@modus21.com."
    static let equalOpportunity = "Modus21 is an Equal Opportunity Employer. It is our policy to provide equal opportunity to all employees and applicants and to prohibit any discrimination because of race, color, religion, sex, national origin, age, marital status, genetic information, disability or protected veteran status."
    static let contactPrompt = "Ready to discuss how Modus21 can support your mission?"
    static let linkedInNote = "To contact us, please reach out through our LinkedIn company page."
    static let footer = "Delivering technology solutions for mission success since 2004."

    static let phoneDisplay = "(843) 958-8900"
    static let phoneURL = URL(string: "tel:8439588900")!
    static let careersEmail = "careers@modus21.com"
    static let careersMail = URL(string: "mailto:careers@modus21.com")!
    static let linkedIn = URL(string: "https://www.linkedin.com/company/modus21-llc-")!
    static let website = URL(string: "https://www.modus21.com/")!
    static let jobs = URL(string: "https://modus21.hua.hrsmart.com/hr/ats/JobSearch/viewAll")!
    static let privacyURL = URL(string: "https://www.modus21.com/privacy-policy")!
    static let accessibilityURL = URL(string: "https://www.modus21.com/accessibility")!

    static let street = "1362 McMillan Avenue"
    static let suite = "Suite 100"
    static let cityLine = "North Charleston, SC 29405"
    static let region = "Charleston, South Carolina"
    static let office = CLLocationCoordinate2D(latitude: 32.8633169, longitude: -79.9693698)

    static var mapsURL: URL {
        var parts = URLComponents(string: "https://maps.apple.com/")!
        parts.queryItems = [
            URLQueryItem(name: "q", value: "Modus21"),
            URLQueryItem(name: "address", value: "\(street), \(suite), \(cityLine)"),
            URLQueryItem(name: "ll", value: "32.8633169,-79.9693698")
        ]
        return parts.url!
    }

    static let facts: [(label: String, value: String)] = [
        ("Founded", "2004"),
        ("Location", "Charleston, South Carolina"),
        ("Business Type", "Small Business"),
        ("Contracts", "Active on Multiple Prime Contracts")
    ]

    static let values: [Value] = [
        Value(name: "Integrity", detail: "We act with honesty, accountability, and respect in every decision."),
        Value(name: "Quality", detail: "We hold our work to high standards because mission outcomes depend on it."),
        Value(name: "Value", detail: "We focus our effort where it creates meaningful results for customers and warfighters.")
    ]

    static let capabilities: [Capability] = [
        Capability(
            name: "Agile Software Development",
            summary: "Iterative delivery practices that keep mission software aligned with evolving operational needs.",
            symbol: "arrow.triangle.2.circlepath"
        ),
        Capability(
            name: "Cloud Computing",
            summary: "Secure cloud migration, data center modernization, and hybrid cloud solutions.",
            symbol: "cloud"
        ),
        Capability(
            name: "Artificial Intelligence",
            summary: "Applied AI solutions that help teams extract insights and improve decision-making.",
            symbol: "sparkles"
        ),
        Capability(
            name: "Systems Integration",
            summary: "Integrated systems planning and implementation for complex mission environments.",
            symbol: "link"
        ),
        Capability(
            name: "Model Based Systems Engineering",
            summary: "SysML-based modeling and digital thread practices that connect requirements, design, and verification across complex defense systems.",
            symbol: "square.stack.3d.up"
        ),
        Capability(
            name: "Business Process Re-engineering",
            summary: "Process analysis and redesign that improves efficiency, quality, and mission outcomes.",
            symbol: "arrow.left.arrow.right"
        ),
        Capability(
            name: "Cybersecurity",
            summary: "Risk management, compliance, and resilient system security.",
            symbol: "lock.shield"
        ),
        Capability(
            name: "DevSecOps",
            summary: "Security engineered into automated development and deployment pipelines to deliver resilient software at mission speed.",
            symbol: "gearshape.2"
        )
    ]

    static let partnerships: [Partnership] = [
        Partnership(name: "Department of War partner", symbol: "flag"),
        Partnership(name: "Prime contractor relationships", symbol: "person.2"),
        Partnership(name: "Highest standards of compliance", symbol: "checkmark.seal"),
        Partnership(name: "NIWC Atlantic program support", symbol: "ferry"),
        Partnership(name: "Naval and joint initiative expertise", symbol: "globe")
    ]

    static let benefits: [String] = [
        "Competitive wage package and discretionary bonus pool",
        "Company-paid Medical Insurance Plan",
        "Company-paid Short and Long Term Disability",
        "Company-paid Dental, Vision, and Life Insurance",
        "401(k) plan with employer matching contribution",
        "Paid time off and holidays",
        "Tuition reimbursement",
        "Employee Assistance Program",
        "Monthly Corporate Wellness Benefit"
    ]
}

struct Value: Identifiable {
    var id: String { name }
    let name: String
    let detail: String
}

struct Capability: Identifiable, Hashable {
    var id: String { name }
    let name: String
    let summary: String
    let symbol: String
}

struct Partnership: Identifiable {
    var id: String { name }
    let name: String
    let symbol: String
}

enum AppTab: Hashable {
    case mission
    case capabilities
    case experience
    case careers
    case contact
}

@Observable
final class AppRouter {
    var tab: AppTab = .mission
}
