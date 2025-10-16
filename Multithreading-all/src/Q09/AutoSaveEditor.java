package Q09;

public class AutoSaveEditor {
	private StringBuilder content = new StringBuilder();

	public AutoSaveEditor() {
		// Daemon thread for auto-saving content
		Thread autoSave = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(10000); // Auto-save every 10 seconds for demo
					saveContent();
					System.out.println("Auto-saved at " + new java.util.Date());
				} catch (InterruptedException e) {
					System.out.println("Auto-save interrupted");
					break;
				}
			}
		});
		autoSave.setDaemon(true); // Daemon thread
		autoSave.setName("AutoSave");
		autoSave.start();
	}

	public void addContent(String text) {
		content.append(text);
	}

	private void saveContent() {
		// Simulate saving content to disk
		System.out.println("Saving: " + content.length() + " characters");
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Auto-Save Editor Demo ===");
		AutoSaveEditor editor = new AutoSaveEditor();

		// Simulate user typing for 35 seconds (demo purpose)
		for (int i = 0; i < 35; i++) {
			editor.addContent("text ");
			Thread.sleep(1000);
		}

		System.out.println("User closed editor");
		// Auto-save daemon stops automatically when main exits
	}
}
